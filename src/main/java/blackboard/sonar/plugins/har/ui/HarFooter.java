package blackboard.sonar.plugins.har.ui;

import org.sonar.api.web.Footer;

public final class HarFooter implements Footer {

  public String getHtml() {
    return "<p>Footer Example - <em>This is static HTML</em></p>";
  }
}
