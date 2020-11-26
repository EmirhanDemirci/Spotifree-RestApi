node{
    stage('SCM Checkout' ) {
      git 'https://github.com/EmirhanDemirci/Spotifree-RestApi/spotifree'
    }
    stage('Compile-Package') {
        // Get maven home path
        def mvnHome = tool name: 'mvn', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
    }
}
