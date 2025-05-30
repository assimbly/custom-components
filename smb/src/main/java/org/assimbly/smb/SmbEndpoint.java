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
package org.assimbly.smb;

import jcifs.smb.SmbFile;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.Processor;
import org.apache.camel.component.file.*;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.support.processor.idempotent.MemoryIdempotentRepository;
import org.assimbly.smb.strategy.SmbProcessStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UriEndpoint(scheme = "smb", title = "SMB", syntax = "smb://user@server.example.com/sharename?password=secret&localWorkDirectory=/tmp")
public class SmbEndpoint extends GenericFileEndpoint<SmbFile> {

    private static final Logger LOG = LoggerFactory.getLogger(SmbEndpoint.class);

    private boolean download = true;

    public SmbEndpoint(final String uri, final SmbComponent smbComponent, final SmbConfiguration configuration) {
        super(uri, smbComponent);
        this.configuration = configuration;
    }

    @Override
    public SmbConfiguration getConfiguration() {
        return (SmbConfiguration)configuration;
    }

    @Override
    public SmbConsumer createConsumer(final Processor processor) throws Exception {
        SmbConsumer consumer = new SmbConsumer(this, processor, createSmbOperations(), processStrategy != null ? processStrategy : createGenericFileStrategy());

        if (isDelete() && getMove() != null) {
            throw new IllegalArgumentException("You cannot set both delete=true and move options");
        }

        // if noop=true then idempotent should also be configured
        if (isNoop() && !isIdempotentSet()) {
            LOG.info("Endpoint is configured with noop=true so forcing endpoint to be idempotent as well");
            setIdempotent(true);
        }

        // if idempotent and no repository set then create a default one
        if (isIdempotentSet() && isIdempotent() && idempotentRepository == null) {
            LOG.info("Using default memory based idempotent repository with cache max size: " + DEFAULT_IDEMPOTENT_CACHE_SIZE);
            idempotentRepository = MemoryIdempotentRepository.memoryIdempotentRepository(DEFAULT_IDEMPOTENT_CACHE_SIZE);
        }

        consumer.setMaxMessagesPerPoll(getMaxMessagesPerPoll());
        consumer.setEagerLimitMaxMessagesPerPoll(isEagerMaxMessagesPerPoll());
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    public PollingConsumer createPollingConsumer() throws Exception {
        return new GenericFilePollingConsumer(this);
    }

    @Override
    public GenericFileProducer<SmbFile> createProducer() throws Exception {
        return new SmbProducer(this, createSmbOperations());
    }

    @Override
    public Exchange createExchange(final GenericFile<SmbFile> file) {
        Exchange answer = new DefaultExchange(getCamelContext());
        if (file != null) {
            file.bindToExchange(answer);
        }
        return answer;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public SmbOperations<SmbFile> createSmbOperations() {
        DefaultSmbClient client = new DefaultSmbClient();
        if (((SmbConfiguration)this.configuration).getSmbApiFactory() != null) {
            client.setSmbApiFactory(((SmbConfiguration)this.configuration).getSmbApiFactory());
        }
        SmbOperations operations = new SmbOperations(client);
        operations.setEndpoint(this);
        return operations;
    }

    @Override
    public String getScheme() {
        return "smb";
    }

    @Override
    public char getFileSeparator() {
        return '/';
    }

    @Override
    public boolean isAbsolute(final String name) {
        return true;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(final boolean download) {
        this.download = download;
    }

    @Override
    protected String createDoneFileName(final String afileName) {
        return super.createDoneFileName(afileName);
    }

    @Override
    protected GenericFileProcessStrategy<SmbFile> createGenericFileStrategy() {
        return SmbProcessStrategyFactory.createGenericFileProcessStrategy(getCamelContext(), getParamsAsMap());
    }

}
