package com.jeroenreijn.examples.view

import com.jeroenreijn.examples.model.Presentation
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

class KotlinxHtmlIndexView {
    companion object {

        fun presentationsTemplate(presentations : Iterable<Presentation> ): String {
            val output = StringBuilder()
            output
                .appendLine("<!DOCTYPE html>")
                .appendHTML()
                    .html {
                        head {
                            meta {charset = "utf-8" }
                            meta {name = "viewport"; content = "width=device-width, initial-scale=1.0" }
                            meta {httpEquiv="x-ua-compatible"; content="IE=Edge" }
                            title { text("JFall 2013 Presentations - kotlinx.html")}
                            link {rel=LinkRel.stylesheet; href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"; media = LinkMedia.screen;}
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

                            script { src = "/webjars/jquery/3.1.1/jquery.min.js" }
                            script { src = "/webjars/bootstrap/4.3.1/js/bootstrap.min.js" }
                        }
                    }
            return output.toString()
        }
    }
}
