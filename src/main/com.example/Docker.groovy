package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        echo "Building the Docker Image"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'pass', usernameVariable: 'user')]){
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}