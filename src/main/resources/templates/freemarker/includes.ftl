[#ftl]
[#macro head]
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
  <title>[@spring.message code="example.title"/] - Freemarker</title>
  <link rel="stylesheet" href="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/5.0.1/css/bootstrap.min.css" media="screen" />
</head>
[/#macro]

[#macro pageTitle]
<div class="pb-2 mt-4 mb-3 border-bottom">
  <h1>[@spring.message code="example.title"/] - Freemarker</h1>
</div>
[/#macro]

[#macro scripts]
<script src="${springMacroRequestContext.getContextPath()}/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
[/#macro]
