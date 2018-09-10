package us.croz.hellok8;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.FormatMethod;
import hellok8.EchoServiceGrpc;
import hellok8.EchoServiceOuterClass.EchoRequest;
import hellok8.EchoServiceOuterClass.EchoResponse;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import java.util.stream.Stream;

public class EchoService extends EchoServiceGrpc.EchoServiceImplBase {

  @Override
  public void echo(EchoRequest request, StreamObserver<EchoResponse> responseStream) {
    try {
      validateArgument(request.getCount() > 0, "A positive count is required");
      validateArgument(!request.getRequest().isEmpty(), "A non-empty request is required");
      responseStream.onNext(EchoResponse.newBuilder()
          .addAllResponse(Stream.generate(request::getRequest)
              .limit(request.getCount())
              .collect(ImmutableList.toImmutableList()))
          .build());
      responseStream.onCompleted();
    } catch (StatusException e) {
      responseStream.onError(e);
    } catch (Throwable t) {
      responseStream.onError(Status.INTERNAL.asException());
    }
  }

  @FormatMethod
  private static void validateArgument(boolean condition, String formatString, Object... args)
      throws StatusException {
    if (!condition) {
      throw Status.INVALID_ARGUMENT
          .withDescription(String.format(formatString, args))
          .asException();
    }
  }
}
