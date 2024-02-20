FROM ubuntu:latest
LABEL authors="tarun"

ENTRYPOINT ["top", "-b"]