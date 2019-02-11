ARG JENKINS_VER=2.150.1
ARG PACKER_VERSION=1.3.3
ARG PACKER_TMP_DIR=/tmp

FROM jenkins/jenkins:${JENKINS_VER}

ARG JENKINS_VER
ARG PACKER_VERSION
ARG PACKER_TMP_DIR

USER root

# create version files to ensure Jenkins does not prompt for setup
# allow slave to master control - https://wiki.jenkins.io/display/JENKINS/Slave+To+Master+Access+Control
# create file for plugin versioning
RUN echo -n ${JENKINS_VER} > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state && \
    echo -n ${JENKINS_VER} > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion && \
    mkdir -p /usr/share/jenkins/ref/secrets/ && echo false > /usr/share/jenkins/ref/secrets/slave-to-master-security-kill-switch

RUN apt update && apt -y install make ruby build-essential patch ruby-dev zlib1g-dev liblzma-dev python-pip libusb-1.0-0-dev libusb-dev libudev-dev

# Install plugins that are predefined in the base-plugins.txt file
COPY plugins.txt /usr/share/jenkins/plugins.txt

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

COPY config/*.xml /usr/share/jenkins/ref/

RUN wget "https://releases.hashicorp.com/packer/${PACKER_VERSION}/packer_${PACKER_VERSION}_linux_amd64.zip" -O ${PACKER_TMP_DIR}/packer.zip
RUN cd ${PACKER_TMP_DIR}; unzip ${PACKER_TMP_DIR}/packer.zip; cp ${PACKER_TMP_DIR}/packer /usr/bin/packer

RUN /usr/bin/pip install aws-google-auth[u2f]
