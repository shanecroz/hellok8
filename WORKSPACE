workspace(name = "us_croz_hellok8")

git_repository(
    name = "io_grpc_grpc_java",
    remote = "https://github.com/grpc/grpc-java.git",
    tag = "v1.14.0",
)

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories(
    omit_com_google_guava = True,
    omit_com_google_protobuf = True,
    omit_com_google_protobuf_javalite = True,
)

http_archive(
    name = "com_google_protobuf",
    sha256 = "cef7f1b5a7c5fba672bec2a319246e8feba471f04dcebfe362d55930ee7c1c30",
    strip_prefix = "protobuf-3.5.0",
    urls = ["https://github.com/google/protobuf/archive/v3.5.0.zip"],
)

http_archive(
    name = "com_google_protobuf_javalite",
    sha256 = "d8a2fed3708781196f92e1e7e7e713cf66804bd2944894401057214aff4f468e",
    strip_prefix = "protobuf-5e8916e881c573c5d83980197a6f783c132d4276",
    urls = ["https://github.com/google/protobuf/archive/5e8916e881c573c5d83980197a6f783c132d4276.zip"],
)

maven_jar(
    name = "com_google_guava_guava",
    artifact = "com.google.guava:guava:26.0-jre",
    sha1 = "6a806eff209f36f635f943e16d97491f00f6bfab",
    sha1_src = "2e35b51c759ae1a6edbb967b65c525105536d382",
)

maven_jar(
    name = "grpc_services_artifact",
    artifact = "io.grpc:grpc-services:1.14.0",
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "97cf62bdef33519412167fd1e4b0810a318a7c234f5f8dc4f53e2da86241c492",
    urls = ["https://github.com/bazelbuild/rules_go/releases/download/0.15.3/rules_go-0.15.3.tar.gz"],
)

load("@io_bazel_rules_go//go:def.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()
