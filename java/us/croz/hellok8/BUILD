#TODO(croz): Remove unused deps from io_grpc
java_library(
    name = "hellok8",
    srcs = glob(["*.java"]),
    deps = [
        "//proto:echo_service_java_grpc",
        "//proto:echo_service_java_proto",
        "@com_google_errorprone_error_prone_annotations//jar",
        "@com_google_guava_guava//jar",
        "@grpc_services_artifact//jar",
        "@io_grpc_grpc_java//alts",
        "@io_grpc_grpc_java//core",
        "@io_grpc_grpc_java//netty",
        "@io_grpc_grpc_java//protobuf",
        "@io_grpc_grpc_java//stub",
        "@io_netty_netty_handler//jar",
    ],
)

java_binary(
    name = "HelloK8Server",
    main_class = "us.croz.hellok8.HelloK8Server",
    runtime_deps = [
        ":hellok8",
    ],
)
