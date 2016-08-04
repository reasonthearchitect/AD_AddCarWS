node {
    stage 'Checkout'
    git url: 'https://github.com/reasonthearchitect/AD_AddCarWS.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])

    stage 'BuildRunDocker'
    //sh 'docker kill addcarws'
    //sh 'docker rm addcarws'
    sh 'docker build -t reasonthearchitect/addcarws .'
    sh 'docker run -d --name addcarws -p 8202:8202 reasonthearchitect/addcarws'
}