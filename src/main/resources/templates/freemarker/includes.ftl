[#ftl]
[#macro head]
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
  <title>[@spring.message code="example.title"/] - Freemarker</title>
  <link rel="stylesheet" href="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" media="screen" />
</head>
[/#macro]

[#macro pageTitle]
<div class=page-header>
  <h1>[@spring.message code="example.title"/] - Freemarker</h1>
</div>
[/#macro]

[#macro scripts]
<script src="${springMacroRequestContext.getContextPath()}/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="${springMacroRequestContext.getContextPath()}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
[/#macro]
