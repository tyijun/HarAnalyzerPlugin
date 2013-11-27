package blackboard.sonar.plugins.har.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

import blackboard.sonar.plugins.har.HarMetrics;
import blackboard.sonar.plugins.har.HarPluginConst;

public class HarSensor implements Sensor {

	private static final Logger LOG = LoggerFactory.getLogger(HarSensor.class);

	private Settings settings;

	/**
	 * Use of IoC to get Settings
	 */
	public HarSensor(Settings settings) {
		this.settings = settings;
	}

	public boolean shouldExecuteOnProject(Project project) {
		// This sensor is executed on any type of projects
		return true;
	}

	public void analyse(Project project, SensorContext sensorContext) {
		String value1 = settings.getString(HarPluginConst.H1_PROPERTY);
		String value2 = settings.getString(HarPluginConst.H2_PROPERTY);
		String value3 = settings.getString(HarPluginConst.H3_PROPERTY);
		LOG.info(HarPluginConst.H1_PROPERTY + "=" + value1);
		LOG.info(HarPluginConst.H2_PROPERTY + "=" + value2);
		LOG.info(HarPluginConst.H3_PROPERTY + "=" + value3);
		Measure measure = new Measure(HarMetrics.MESSAGE, value3);
		sensorContext.saveMeasure(measure);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
