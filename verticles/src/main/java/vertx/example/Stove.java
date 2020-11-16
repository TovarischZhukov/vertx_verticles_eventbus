package vertx.example;

import io.vertx.core.AbstractVerticle;

@SuppressWarnings({"MagicNumber", "UseOfSystemOutOrSystemErr"})
public final class Stove extends AbstractVerticle {

  @Override
  public void start() {
    System.out.println("Start Stove");
  }
}
