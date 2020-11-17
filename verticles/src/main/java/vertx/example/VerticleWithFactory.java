package vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.impl.JavaVerticleFactory;

@SuppressWarnings({"MagicNumber", "UseOfSystemOutOrSystemErr"})
public final class VerticleWithFactory extends AbstractVerticle {
  private final long number;

  private VerticleWithFactory(long number) {
    this.number = number;
  }

  @Override
  public void start() {
    System.out.println("Start " + number + " VerticleWithFactory");
  }

  @SuppressWarnings("NotNullNullableValidation")
  public static final class Factory extends JavaVerticleFactory {
    private long verticleNumber;

    @Override
    public String prefix() {
      return "sphere";
    }

    @SuppressWarnings("ProhibitedExceptionDeclared")
    @Override
    public Verticle createVerticle(String verticleName, ClassLoader classLoader) {
      return new VerticleWithFactory(verticleNumber++);
    }
  }
}