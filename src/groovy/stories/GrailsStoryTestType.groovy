package stories

import org.codehaus.groovy.grails.test.GrailsTestTypeResult
import org.codehaus.groovy.grails.test.support.GrailsTestTypeSupport
import org.codehaus.groovy.grails.test.event.GrailsTestEventPublisher
import org.codehaus.groovy.grails.test.GrailsTestTargetPattern
import stories.GrailsStoryTestTypeResult

class GrailsStoryTestType extends GrailsTestTypeSupport {
    GrailsStoryTestType(String name, String relativeSourcePath) {
        super(name, relativeSourcePath)
    }

    protected List<String> getTestExtensions() {
        ["groovy"]
    }

    protected List<String> getTestSuffixes() { 
        ["Story"]
    }

    protected int doPrepare() {
        for (GrailsTestTargetPattern targetPattern : this.getTestTargetPatterns()) {
            for (File file : findSourceFiles(targetPattern)) {
                println file
            }
        }
        //TODO: return the real number of tests
        return 1;
    }

    GrailsTestTypeResult doRun(GrailsTestEventPublisher eventPublisher) {
        return new GrailsStoryTestTypeResult()    
    }
}
