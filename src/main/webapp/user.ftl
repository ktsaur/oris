<html lang="en">
<#include "base.ftl">

<#macro title>Users</#macro>

<#macro content>
    <#if users?has_content>
        Пользователи:
        Имя Очки
        <br>
        <#list users as u>
            ${u.getName()}
            ${u.getScore()}
            <br>
        </#list>
    </#if>

</#macro>
</html>