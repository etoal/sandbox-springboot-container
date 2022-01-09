FROM openjdk:11

ENV INSTALL_DIR=/local/apps/springboot-container
ENV DISTRIBUTION_PREFIX=sandbox-springboot-container-boot-0.0.1-SNAPSHOT
ENV DISTRIBUTION_NAME=${DISTRIBUTION_PREFIX}.tar

  RUN mkdir -p ${INSTALL_DIR}
  COPY build/distributions/${DISTRIBUTION_NAME} ${INSTALL_DIR}
  WORKDIR ${INSTALL_DIR}
  RUN tar -xvf ${DISTRIBUTION_NAME}

  ENTRYPOINT ${INSTALL_DIR}/${DISTRIBUTION_PREFIX}/bin/sandbox-springboot-container

EXPOSE 8090
