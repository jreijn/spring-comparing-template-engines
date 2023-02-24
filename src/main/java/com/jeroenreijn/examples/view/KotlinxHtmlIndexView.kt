package com.jeroenreijn.examples.view

import com.jeroenreijn.examples.model.Presentation
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class KotlinxHtmlIndexView {
    companion object {

        fun presentationsTemplate(presentations : Iterable<Presentation> ): String {
            val output = StringBuilder()
            output
                .appendHTML()
                    .html {
                        head {
                            meta {charset = "utf-8" }
                            meta {name = "viewport"; content = "width=device-width, initial-scale=1.0" }
                            meta {httpEquiv=MetaHttpEquiv.contentLanguage; content="IE=Edge" }
                            title { text("JFall 2013 Presentations - htmlApi")}
                            link {rel=LinkRel.stylesheet; href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"; media = LinkMedia.screen;}
                        }
                        body {
                            div {
                                classes = setOf("container")
                                div {
                                    classes = setOf("pb-2 mt-4 mb-3 border-bottom")
                                    h1 { text("JFall 2013 Presentations - kotlinx.html") }
                                }

                                presentations.forEach {
                                    div {
                                        classes = setOf("card mb-3 shadow-sm rounded")
                                        div {
                                            classes = setOf("card-header")
                                            h5 {
                                                classes = setOf("card-title")
                                                text( it.title + " - " + it.speakerName)
                                            }
                                        }
                                        div {
                                            classes = setOf("card-body")
                                            unsafe { raw(it.summary) }
                                        }
                                    }
                                }
                            }

                            script { src = "/webjars/bootstrap/5.2.3/js/bootstrap.min.js" }
                        }
                    }
            return output.toString()
        }
    }
}
