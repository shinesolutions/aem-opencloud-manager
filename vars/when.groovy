# This shared library is used to check a condition that allows a stage to
# potentially be skipped.
# License: https://github.com/comquent/imperative-when/blob/master/LICENSE

import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call(boolean condition, body) {
    def config = [:]
    body.resolveStrategy = Closure.OWNER_FIRST
    body.delegate = config

    if (condition) {
        body()
    } else {
        Utils.markStageSkippedForConditional(STAGE_NAME)
    }
}
