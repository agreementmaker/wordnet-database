package com.github.agreementmaker.wordnet;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordNetDatabaseTest {
    @Test
    public void wordnet_files_are_on_the_classpath() throws URISyntaxException, IOException {
        URL fileUrl = Thread.currentThread().getContextClassLoader().getResource("dict/index.sense");
        assert fileUrl != null;
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(fileUrl.toURI()), "r");

        randomAccessFile.seek(1337l);
        assertThat(randomAccessFile.readByte(), is((byte)'r'));
        assertThat(randomAccessFile.readByte(), is((byte)'d'));
        assertThat(randomAccessFile.readByte(), is((byte)'i'));
        assertThat(randomAccessFile.readByte(), is((byte)'n'));
        assertThat(randomAccessFile.readByte(), is((byte)'a'));
        assertThat(randomAccessFile.readByte(), is((byte)'l'));
    }

}