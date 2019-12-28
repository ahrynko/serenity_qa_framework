package jbehave.scenariosteps;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.steps.ParameterControls;

import java.util.Optional;

public class AcceptanceTestSuite extends SerenityStories {

    private static final String STORY_FILE = "story.file";

    public AcceptanceTestSuite() {
        super();
        Optional.ofNullable(System.getProperty(STORY_FILE)).ifPresent(this::findStoriesCalled);
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
        configuration().usePendingStepStrategy(new FailingUponPendingStep());
    }
}
