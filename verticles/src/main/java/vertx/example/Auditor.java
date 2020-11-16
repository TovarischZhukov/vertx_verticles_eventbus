package vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.impl.JavaVerticleFactory;

@SuppressWarnings({"MagicNumber", "UseOfSystemOutOrSystemErr"})
public final class Auditor extends AbstractVerticle {
  private final long number;

  private Auditor(long number) {
    this.number = number;
  }

  @Override
  public void start() {
    System.out.println("Start " + number + " auditor");
  }

  @SuppressWarnings("NotNullNullableValidation")
  public static final class Factory extends JavaVerticleFactory {
    private long auditorNumber;

    @Override
    public String prefix() {
      return "sphere";
    }

    @SuppressWarnings("ProhibitedExceptionDeclared")
    @Override
    public Verticle createVerticle(String verticleName, ClassLoader classLoader) {
      return new Auditor(auditorNumber++);
    }
  }
}