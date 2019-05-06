[#ftl]
[#import "includes.ftl" as example/]
<!DOCTYPE html>
<html>
[@example.head/]
<body>
<div class="container">
[@example.pageTitle/]
    [#list presentations as presentation]
        <div class="card mb-3 shadow-sm rounded">
            <div class="card-header">
                <h5 class="card-title">${presentation.title} - ${presentation.speakerName}</h5>
            </div>
            <div class="card-body">
            ${presentation.summary}
            </div>
        </div>
    [/#list]
</div>
[@example.scripts/]
</body>
</html>