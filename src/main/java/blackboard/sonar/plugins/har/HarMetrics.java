package blackboard.sonar.plugins.har;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

public final class HarMetrics implements Metrics {

	public static final String HAR_DOMAIN = "HAR Analysis";

	public static final Metric MESSAGE = new Metric.Builder("message_key",
			"Message", Metric.ValueType.STRING)
			.setDescription("This is a metric to store a well known message")
			.setDirection(Metric.DIRECTION_WORST).setQualitative(false)
			.setDomain(HAR_DOMAIN).create();

	public static final Metric RANDOM = new Metric.Builder("random", "Random",
			Metric.ValueType.FLOAT).setDescription("Random value")
			.setDirection(Metric.DIRECTION_BETTER).setQualitative(false)
			.setDomain(HAR_DOMAIN).create();

	// getMetrics() method is defined in the Metrics interface and is used by
	// Sonar to retrieve the list of new metrics
	public List<Metric> getMetrics() {
		return Arrays.asList(MESSAGE, RANDOM);
	}
}
