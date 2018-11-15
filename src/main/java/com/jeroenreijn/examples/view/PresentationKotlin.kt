package com.jeroenreijn.examples.view

import com.jeroenreijn.examples.model.Presentation
import kotlinx.html.*
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize

class PresentationsKotlin {
    companion object {

        fun presentationsTemplate(presentations : Collection<Presentation> ): String {
            return createHTMLDocument()
                    .html {
                        head {
                            meta {charset = "utf-8" }
                            meta {name = "viewport"; content = "width=device-width, initial-scale=1.0" }
                            meta {httpEquiv=MetaHttpEquiv.contentLanguage; content="IE=Edge" }
                            title { text("JFall 2013 Presentations - KotlinHtml")}
                            link {rel=LinkRel.stylesheet; href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"; media = LinkMedia.screen}
                        }
                        body {
                            div {
                                classes = setOf("container")
                                div {
                                    classes = setOf("page-header")
                                    h1 { text("JFall 2013 Presentations - htmlApi") }
                                }

                                presentations.forEach {
                                    div {
                                        classes = setOf("panel panel-default")
                                        div {
                                            classes = setOf("panel-heading")
                                            h3 {
                                                classes = setOf("panel-title")
                                                text( it.title + " - " + it.speakerName)
                                            }
                                        }
                                        div {
                                            classes = setOf("panel-body")
                                            text (it.summary)
                                        }
                                    }
                                }
                            }

                            script { src = "/webjars/jquery/3.1.1/jquery.min.js" }
                            script { src = "/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" }
                        }
                    }.serialize(false)
        }
    }


}