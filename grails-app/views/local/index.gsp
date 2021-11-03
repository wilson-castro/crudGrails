<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Gerenciamento de locais</title>
    <g:javascript library="jquery" />
</head>
<body>
    <g:remoteLink controller="local" action="adicionar" update="divForm">Adicionar</g:remoteLink>

    <div id="divLista">
        <g:render template="lista" model="[locais:locais]"></g:render>
    </div>

    <br>

    <div id="divForm"></div>
</body>
</html>