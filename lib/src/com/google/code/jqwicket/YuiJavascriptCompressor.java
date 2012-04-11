package com.google.code.jqwicket;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;
import org.apache.wicket.javascript.IJavaScriptCompressor;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author mkalina
 * @version $Id$
 */
public class YuiJavascriptCompressor implements IJavaScriptCompressor {

    private static final Logger log = LoggerFactory.getLogger(YuiJavascriptCompressor.class);

    private static YuiJavascriptCompressor instance;

    private static final ErrorReporter yuiErrorReporter = new ErrorReporter() {
        public void warning(String s, String s1, int i, String s2, int i1) {
            log.warn("yui compressor warning: detail = {}, sourceName = {}, lineNumber = {}, " +
                    "lineSource = {}, columnNumber = {}", new Object[]{s, s1, i, s2, i1});
        }

        public void error(String s, String s1, int i, String s2, int i1) {
            log.error("yui compressor warning: detail = {}, sourceName = {}, lineNumber = {}, " +
                    "lineSource = {}, columnNumber = {}", new Object[]{s, s1, i, s2, i1});
        }

        public EvaluatorException runtimeError(String s, String s1, int i, String s2, int i1) {
            throw new EvaluatorException(s, s1, i, s2, i1);
        }
    };

    public static final YuiJavascriptCompressor get() {
        if (instance == null)
            instance = new YuiJavascriptCompressor();

        return instance;
    }

    /**
     * {@inheritDoc}
     */
    public String compress(final String original) {

        if (Utils.isBlank(original))
            return original;

        try {
            StringWriter result = new StringWriter();
            JavaScriptCompressor compressor = new JavaScriptCompressor(new StringReader(original), yuiErrorReporter);
            compressor.compress(result, -1, true, false, false, false);
            result.flush();
            return result.toString();
        } catch (IOException e) {
            log.error("Error compressing javascript with yui-compressor! Returning original javascript", e);
        }

        return original;
    }

}
