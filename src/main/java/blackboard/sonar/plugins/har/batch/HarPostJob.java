package blackboard.sonar.plugins.har.batch;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.CheckProject;
import org.sonar.api.batch.PostJob;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Project;

import blackboard.sonar.plugins.har.HarMAO;
import blackboard.sonar.plugins.har.HarPluginConst;

public class HarPostJob implements PostJob, CheckProject {

	public static final Logger LOG = LoggerFactory.getLogger(HarPostJob.class);

	public boolean shouldExecuteOnProject(Project project) {
		return true;
	}

	public void executeOn(Project project, SensorContext context) {
		// this sensor is executed if no props defined on Har project
		String p1 = (String) project.getProperty(HarPluginConst.H1_PROPERTY);
		String p2 = (String) project.getProperty(HarPluginConst.H2_PROPERTY);
		String p3 = (String) project.getProperty(HarPluginConst.H3_PROPERTY);
		if (StringUtils.isNotBlank(p1) || StringUtils.isNotBlank(p2)
				|| StringUtils.isNotBlank(p3)) {
			return;
		}

		LOG.debug("START HarPostJob");

		try {
			// Get and parse the HAR analysis data
			/*
			 * Object data = null; if (data != null) {
			 * HarMAO.saveDataAsMetrics(data, context); }
			 */
		} catch (Exception e) {
			LOG.error("Cannot analyse project '" + project.getName() + "'", e);
		}

		LOG.debug("END HarPostJob");
	}

}
