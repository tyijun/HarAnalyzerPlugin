package blackboard.sonar.plugins.har;

import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Measure;

/**
 * HarMAO HAR Metrics Access Object
 * 
 * This class abstracts how HAR analysis data is saved as Metrics
 */
public class HarMAO {
	/**
	 * Save HAR analysis data as sonar metrics
	 */
	public static void saveDataAsMetrics(Object data, SensorContext context) {

		context.saveMeasure(HarMetrics.RANDOM, 0.1);
		context.saveMeasure(new Measure(HarMetrics.MESSAGE, "Test"));

	}

}
