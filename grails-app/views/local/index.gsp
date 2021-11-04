<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Gerenciamento de locais</title>
    <g:javascript library="jquery" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script type="text/javascript">
        function carregarLista(){
            <g:remoteFunction controller="local" action="listar"  update="divLista" />
        }

        function carregarListaFiltrada(){
            const nome = document.getElementById("inputBuscarPorNome").value
            const parameters = { "nome":nome}

            <g:remoteFunction controller="local" action="procurarPorNome" update="divLista"
                params="parameters"/>

        }

        function excluir(id){
            if(confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="local" action="excluir" update="divLista" id="'+id+'" />
            }
        }

    </script>
</head>
<body>
    <g:remoteLink controller="local" action="prepararForm" update="divForm">Adicionar</g:remoteLink>

    <div id="divBuscar">
        <input id="inputBuscarPorNome" type="text" placeholder="Digite o nome para buscar..."><br>

        <button name="btnPesquisar" onclick="carregarListaFiltrada()">Procurar</button>
        <br>
    </div>

    <div id="divLista">
        <g:render template="lista" model="[locais:locais]"></g:render>
    </div>

    <br>

    <div id="divForm"></div>
</body>
</html>