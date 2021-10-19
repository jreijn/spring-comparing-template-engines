[#ftl]
[#macro head]
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
  <title>[@spring.message code="example.title"/] - Freemarker</title>
  <link rel="stylesheet" href="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/css/bootstrap.min.css" media="screen" />
</head>
[/#macro]

[#macro pageTitle]
<div class="pb-2 mt-4 mb-3 border-bottom">
  <h1>[@spring.message code="example.title"/] - Freemarker</h1>
</div>
[/#macro]

[#macro scripts]
<script src="${springMacroRequestContext.getContextPath()}/webjars/jquery/jquery.min.js"></script>
<script src="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/js/bootstrap.min.js"></script>
[/#macro]
