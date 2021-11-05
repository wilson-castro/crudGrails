<g:if test="${shows.size() > 0}">
    <table>
        <caption>Lista de shows</caption>
        <thead>
        <tr>
            <th>ONDE</th>
            <th>DATA</th>
            <th>Nº DE BANDAS</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>

        <g:each var="show" in="${shows}">
            <tr>
                <td>${show.localDoShow?.nome}</td>
                <td>${show.dataDoShow.format("dd/MM/yyyyy")}</td>
                <td>${show.bandasNoShow?.size()}</td>
                <td>
                    <g:remoteLink controller="show" action="alterar" update="divForm" id="${show.id}">Alterar</g:remoteLink>
                    <a href="#" onclick="excluir(${show.id})" >Excluir</a>
                </td>
            </tr>
        </g:each>

        </tbody>
    </table>
</g:if>
<g:else>
    <br>
    <h5>Não há shows</h5>
</g:else>