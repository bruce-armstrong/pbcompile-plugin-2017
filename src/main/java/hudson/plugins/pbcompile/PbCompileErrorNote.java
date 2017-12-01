package hudson.plugins.pbcompile;

import hudson.Extension;
import hudson.MarkupText;
import hudson.console.ConsoleAnnotationDescriptor;
import hudson.console.ConsoleAnnotator;
import hudson.console.ConsoleNote;
import org.jenkinsci.Symbol;

import java.util.regex.Pattern;

/**
 * Annotation for PBC and CSC error messages
 */
public class PbCompileErrorNote extends ConsoleNote {
    /** Pattern to identify error messages */
    public final static Pattern PATTERN = Pattern.compile("(.*)[Ee]rror\\s(([A-Z]*)\\d+){0,1}:\\s(.*)");
    
    public PbCompileErrorNote() {
    }

    @Override
    public ConsoleAnnotator annotate(Object context, MarkupText text, int charPos) {
        text.addMarkup(0, text.length(), "<span class=error-inline>", "</span>");
        return null;
    }

    @Extension @Symbol("pbcompileError")
    public static final class DescriptorImpl extends ConsoleAnnotationDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.PbCompileBuilder_ErrorNoteDescription();
        }
    }
}
