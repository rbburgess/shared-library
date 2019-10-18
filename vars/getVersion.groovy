def call() {
    def conanFileExists = fileExists "conanfile.py"

    if(conanFileExists) {
        def file = readFile "conanfile.py"
        def lines = file.split("\n")
        String versionLine
        for (int i = 0; i< lines.size();i++){
            if(lines[i] =~ /(   version) ?= ?['"].+['"]/){
                versionLine = lines[i]
            }
        }

        String version = versionLine.split("=")[1].trim()
        version = version.substring(1, version.length() - 1)

        sh "echo Version: ${version}."
    }
}