<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Gerenciamento de bandas</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <g:javascript library="jquery" />
    <script>
        function carregarLista(){
            <g:remoteFunction controller="banda" action="listar"  update="divLista" />
        }

        function carregarListaFiltrada(){
            const nome = document.getElementById("inputBuscarPorNome").value
            let listaGenerosMarcados = [...$('input[name="listGeneros[]"]:checked').map(function(){
                return this.value;
            }).get()]

            const parameters = { "nome":nome, "listaGeneros":listaGenerosMarcados}

            <g:remoteFunction controller="banda" action="procurarPorNomeEGenero"  update="divLista"
                params="parameters"/>
        }

        function excluir(id){
            if(confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="banda" action="excluir" update="divLista" id="'+id+'" />
            }
        }

    </script>
</head>
<body>

    <g:remoteLink controller="banda" action="prepararForm" update="divForm">Adicionar</g:remoteLink>
    <br>

    <div class="filtros">
        <div id="inputNome">
            <input id="inputBuscarPorNome" type="text" name="inputBuscarNome" placeholder="Digite um nome...">
            <button value="Procurar"  name="btnPesquisar" onclick="carregarListaFiltrada()" >Procurar</button>
        </div>
        <div class="group-checkbox">
            <input type="checkbox" id="ROCK" name="listGeneros[]" value="ROCK">
            <label for="ROCK"> ROCK</label>
            <input type="checkbox" id="FORRO" name="listGeneros[]" value="FORRO">
            <label for="FORRO"> FORRÓ</label>
            <input type="checkbox" id="AXE" name="listGeneros[]" value="AXE">
            <label for="AXE"> AXÉ</label>
        </div>
    </div>

    <div id="divLista">
        <g:render template="lista" model="[bandas:bandas]"></g:render>
    </div>

    <br>

    <div id="divForm"></div>

</body>
</html>