ARG JENKINS_VER=2.150.1
FROM jenkins/jenkins:${JENKINS_VER}

ARG JENKINS_VER

USER root

# create version files to ensure Jenkins does not prompt for setup
# allow slave to master control - https://wiki.jenkins.io/display/JENKINS/Slave+To+Master+Access+Control
# create file for plugin versioning
RUN echo -n ${JENKINS_VER} > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state && \
    echo -n ${JENKINS_VER} > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion && \
    mkdir -p /usr/share/jenkins/ref/secrets/ && echo false > /usr/share/jenkins/ref/secrets/slave-to-master-security-kill-switch

RUN apt update && apt -y install make ruby build-essential patch ruby-dev zlib1g-dev liblzma-dev

# Install plugins that are predefined in the base-plugins.txt file
COPY plugins.txt /usr/share/jenkins/plugins.txt

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

COPY config/*.xml /usr/share/jenkins/ref/
