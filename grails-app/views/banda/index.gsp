<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Gerenciamento de bandas</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <g:javascript library="jquery" />
    <script>


    </script>
</head>
<body>

    <g:remoteLink controller="local" action="adicionar" update="divForm">Adicionar</g:remoteLink>

    <div id="divLista">
        <g:render template="lista" model="[locais:locais]"></g:render>
    </div>

    <div id="divForm"></div>

</body>
</html>