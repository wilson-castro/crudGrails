
<table>
    <caption>Bandas</caption>
    <thead>
        <tr>
            <th>Nome</th>
            <th>Genero</th>
            <th>Shows</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>

        <g:each var="banda" in="${bandas}">
            <tr>
                    <td>${banda.nome}</td>
                    <td>${banda.genero}</td>
                    <td>${banda.shows}</td>
                    <td>
                        <a href="#" >Alterar</a>
                        <a href="#">Excluir</a>
                    </td>
                </tr>
        </g:each>

    </tbody>
</table>