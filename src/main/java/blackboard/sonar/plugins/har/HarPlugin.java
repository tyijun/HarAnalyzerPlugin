package blackboard.sonar.plugins.har;

import blackboard.sonar.plugins.har.batch.HarDecorator;
import blackboard.sonar.plugins.har.batch.HarPostJob;
import blackboard.sonar.plugins.har.batch.HarSensor;
import blackboard.sonar.plugins.har.ui.HarFooter;
import blackboard.sonar.plugins.har.ui.HarRubyWidget;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

/**
 * This class is the entry point for all extensions
 */
@Properties({
		@Property(key = HarPluginConst.H1_PROPERTY, name = "Har Analyzer Plugin Property 1", description = "A property for the Har Analyzer Plugin", defaultValue = "Hello World!", project = true, global = true),
		@Property(key = HarPluginConst.H2_PROPERTY, name = "Har Analyzer Plugin Property 2", description = "A property for the Har Analyzer Plugin", defaultValue = "Hello Joey!", project = true, global = true),
		@Property(key = HarPluginConst.H3_PROPERTY, name = "Har Analyzer Plugin Property 3", description = "A property for the Har Analyzer Plugin", defaultValue = "Hello Sonar!", project = true, global = true) })
public final class HarPlugin extends SonarPlugin {

	// This is where you're going to declare all your Sonar extensions
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getExtensions() {
		return Arrays.asList(
				// Definitions
				HarMetrics.class,
				// Batch
				HarSensor.class, HarDecorator.class, HarPostJob.class,
				// UI
				HarFooter.class, HarRubyWidget.class);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
