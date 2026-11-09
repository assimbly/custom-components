/**************************************************************************************
 https://camel-extra.github.io

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation; either version 3
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.


 You should have received a copy of the GNU Lesser General Public
 License along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 02110-1301, USA.

 http://www.gnu.org/licenses/lgpl-3.0-standalone.html
 ***************************************************************************************/
package org.assimbly.smb.strategy;

import java.util.Map;
import java.util.function.Consumer;

import org.apache.camel.Expression;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.file.GenericFileExclusiveReadLockStrategy;
import org.apache.camel.component.file.GenericFileProcessStrategy;
import org.apache.camel.component.file.strategy.GenericFileDeleteProcessStrategy;
import org.apache.camel.component.file.strategy.GenericFileExpressionRenamer;
import org.apache.camel.component.file.strategy.GenericFileNoOpProcessStrategy;
import org.apache.camel.component.file.strategy.GenericFileRenameExclusiveReadLockStrategy;
import org.apache.camel.component.file.strategy.GenericFileRenameProcessStrategy;
import org.apache.camel.util.ObjectHelper;
import org.codelibs.jcifs.smb.impl.SmbFile;

/**
 * see org.apache.camel.component.file.remote.strategy.SftpProcessStrategyFactory
 */
public final class SmbProcessStrategyFactory {

    private SmbProcessStrategyFactory() {
    }

    public static GenericFileProcessStrategy<SmbFile> createGenericFileProcessStrategy(final Map<String, Object> params) {

        // We assume a value is present only if its value not null for String and 'true' for boolean
        Expression moveExpression = (Expression) params.get("move");
        Expression moveFailedExpression = (Expression) params.get("moveFailed");
        Expression preMoveExpression = (Expression) params.get("preMove");
        boolean isNoop = params.get("noop") != null;
        boolean isDelete = params.get("delete") != null;
        boolean isMove = moveExpression != null || preMoveExpression != null || moveFailedExpression != null;

        if (isDelete) {
            return createDeleteStrategy(params, preMoveExpression, moveFailedExpression);
        } else if (isMove || isNoop) {
            return createRenameStrategy(params, isNoop, moveExpression, preMoveExpression, moveFailedExpression);
        } else {
            // default strategy will do nothing
            GenericFileNoOpProcessStrategy<SmbFile> strategy = new GenericFileNoOpProcessStrategy<>();
            strategy.setExclusiveReadLockStrategy(getExclusiveReadLockStrategy(params));
            return strategy;
        }
    }

    private static GenericFileProcessStrategy<SmbFile> createDeleteStrategy(
            final Map<String, Object> params, final Expression preMoveExpression, final Expression moveFailedExpression) {
        GenericFileDeleteProcessStrategy<SmbFile> strategy = new GenericFileDeleteProcessStrategy<>();
        strategy.setExclusiveReadLockStrategy(getExclusiveReadLockStrategy(params));
        if (preMoveExpression != null) {
            strategy.setBeginRenamer(createRenamer(preMoveExpression));
        }
        if (moveFailedExpression != null) {
            strategy.setFailureRenamer(createRenamer(moveFailedExpression));
        }
        return strategy;
    }

    private static GenericFileProcessStrategy<SmbFile> createRenameStrategy(
            final Map<String, Object> params, final boolean isNoop, final Expression moveExpression,
            final Expression preMoveExpression, final Expression moveFailedExpression) {
        GenericFileRenameProcessStrategy<SmbFile> strategy = new GenericFileRenameProcessStrategy<>();
        strategy.setExclusiveReadLockStrategy(getExclusiveReadLockStrategy(params));
        if (!isNoop && moveExpression != null) {
            // move on commit is only possible if not noop
            strategy.setCommitRenamer(createRenamer(moveExpression));
        }
        if (moveFailedExpression != null) {
            strategy.setFailureRenamer(createRenamer(moveFailedExpression));
        }
        // both move and noop supports pre move
        if (preMoveExpression != null) {
            strategy.setBeginRenamer(createRenamer(preMoveExpression));
        }
        return strategy;
    }

    private static GenericFileExpressionRenamer<SmbFile> createRenamer(final Expression expression) {
        GenericFileExpressionRenamer<SmbFile> renamer = new GenericFileExpressionRenamer<>();
        renamer.setExpression(expression);
        return renamer;
    }

    @SuppressWarnings("unchecked")
    private static GenericFileExclusiveReadLockStrategy<SmbFile> getExclusiveReadLockStrategy(final Map<String, Object> params) {
        GenericFileExclusiveReadLockStrategy<SmbFile> strategy = (GenericFileExclusiveReadLockStrategy<SmbFile>) params.get("exclusiveReadLockStrategy");
        if (strategy != null) {
            return strategy;
        }

        // no explicit strategy set then fallback to readLock option
        String readLock = (String) params.get("readLock");
        if (ObjectHelper.isEmpty(readLock)) {
            return null;
        }

        return switch (readLock) {
            case "rename" -> createRenameReadLockStrategy(params);
            case "changed" -> createChangedReadLockStrategy(params);
            case "none" -> null; // no readlock needed
            default -> throw new IllegalStateException("Unexpected value: " + readLock);
        };
    }

    private static GenericFileExclusiveReadLockStrategy<SmbFile> createRenameReadLockStrategy(final Map<String, Object> params) {
        GenericFileRenameExclusiveReadLockStrategy<SmbFile> readLockStrategy = new GenericFileRenameExclusiveReadLockStrategy<>();
        applyCommonReadLockOptions(params, readLockStrategy);
        return readLockStrategy;
    }

    private static GenericFileExclusiveReadLockStrategy<SmbFile> createChangedReadLockStrategy(final Map<String, Object> params) {
        SmbChangedExclusiveReadLockStrategy readLockStrategy = new SmbChangedExclusiveReadLockStrategy();
        applyCommonReadLockOptions(params, readLockStrategy);
        applyIfPresent(params, "readLockMinLength", Long.class, readLockStrategy::setMinLength);
        applyIfPresent(params, "readLockMinAge", Long.class, readLockStrategy::setMinAge);
        return readLockStrategy;
    }

    private static void applyCommonReadLockOptions(final Map<String, Object> params, final GenericFileExclusiveReadLockStrategy<SmbFile> readLockStrategy) {
        applyIfPresent(params, "readLockTimeout", Long.class, readLockStrategy::setTimeout);
        applyIfPresent(params, "readLockCheckInterval", Long.class, readLockStrategy::setCheckInterval);
        applyIfPresent(params, "readLockLoggingLevel", LoggingLevel.class, readLockStrategy::setReadLockLoggingLevel);
    }

    private static <T> void applyIfPresent(final Map<String, Object> params, final String key, final Class<T> type, final Consumer<T> setter) {
        Object value = params.get(key);
        if (value != null) {
            setter.accept(type.cast(value));
        }
    }

}
