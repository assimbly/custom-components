package org.assimbly.smb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.file.GenericFileEndpoint;
import org.apache.camel.component.file.GenericFileOperations;
import org.apache.camel.component.file.GenericFileProcessStrategy;
import org.apache.camel.impl.DefaultCamelContext;
import org.codelibs.jcifs.smb.impl.SmbFile;
import org.junit.jupiter.api.Test;

class SmbConsumerTest {

    @Test
    @SuppressWarnings("unchecked")
    void recursivePollKeepsSubdirectoryInRelativePath() throws Exception {
        CamelContext context = new DefaultCamelContext();
        SmbConfiguration configuration = mock(SmbConfiguration.class);
        when(configuration.getDirectory()).thenReturn("share");

        GenericFileEndpoint<SmbFile> endpoint = mock(GenericFileEndpoint.class);
        when(endpoint.getConfiguration()).thenReturn(configuration);
        when(endpoint.getCamelContext()).thenReturn(context);
        when(endpoint.isRecursive()).thenReturn(true);
        when(endpoint.getMaxMessagesPerPoll()).thenReturn(0);

        SmbFile subDirectory = smbFile("sub/", true);
        SmbFile nestedFile = smbFile("file.txt", false);

        GenericFileOperations<SmbFile> operations = mock(GenericFileOperations.class);
        when(operations.listFiles(anyString())).thenReturn(new SmbFile[] { nestedFile });
        when(operations.listFiles("share")).thenReturn(new SmbFile[] { subDirectory });

        SmbConsumer consumer = new SmbConsumer(endpoint, mock(Processor.class), operations, mock(GenericFileProcessStrategy.class));

        List<GenericFile<SmbFile>> files = new ArrayList<>();
        consumer.pollDirectory(mock(Exchange.class), "share", files, 0);

        assertEquals(1, files.size());
        GenericFile<SmbFile> polled = files.getFirst();
        assertEquals("sub/file.txt", polled.getFileName());
        assertTrue(polled.getRelativeFilePath().startsWith("sub/"),
                "relative path should include the subdirectory but was: " + polled.getRelativeFilePath());
    }

    private static SmbFile smbFile(String name, boolean directory) throws Exception {
        SmbFile file = mock(SmbFile.class);
        when(file.getName()).thenReturn(name);
        when(file.getCanonicalPath()).thenReturn("smb://host/share/" + name);
        when(file.isDirectory()).thenReturn(directory);
        return file;
    }
}
