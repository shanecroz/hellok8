package us.croz.hellok8;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Introduction to Kubernetes
 */
public class HelloK8Server {

  private static final Logger logger = Logger.getLogger(HelloK8Server.class.getName());

  private static final int PORT = 8080;

  private final Server server;

  HelloK8Server() {
    this.server = ServerBuilder.forPort(PORT)
        .addService(new EchoService())
        .addService(ProtoReflectionService.newInstance())
        .build();
  }

  private void start() throws InterruptedException, IOException {
    server.start();
    logger.info("Server started, listening on " + PORT);
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      HelloK8Server.this.stop();
      System.err.println("*** server shut down");
    }));
    server.awaitTermination();
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  public static void main(String args[]) throws Exception {
    new HelloK8Server().start();
  }
}
