yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
  head {
    include template: 'head.tpl'
  }
  body {
    div(class:'container') {
      div(class: 'pb-2 mt-4 mb-3 border-bottom') {
        h1(title)
      }

	  mainBody()
    }
  }

  include template: 'scripts.tpl'
}