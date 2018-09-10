load("@io_bazel_rules_go//proto:def.bzl", "go_proto_library")
load("@io_grpc_grpc_java//:java_grpc_library.bzl", "java_grpc_library")

package_group(
    name = "echo_service_clients",
    packages = [
        "//go/echo",
        "//java/us/croz/hellok8",
    ],
)

go_proto_library(
    name = "echo_service_go_proto",
    compilers = ["@io_bazel_rules_go//proto:go_grpc"],
    importpath = "croz.us/hellok8/echo",
    proto = ":echo_service_proto",
    visibility = [":echo_service_clients"],
    deps = [],
)

java_grpc_library(
    name = "echo_service_java_grpc",
    srcs = [":echo_service_proto"],
    visibility = [":echo_service_clients"],
    deps = [":echo_service_java_proto"],
)

java_proto_library(
    name = "echo_service_java_proto",
    visibility = [":echo_service_clients"],
    deps = [":echo_service_proto"],
)

proto_library(
    name = "echo_service_proto",
    srcs = ["echo_service.proto"],
    visibility = [":echo_service_clients"],
)
