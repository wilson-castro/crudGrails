<g:if test="${bandas.size() > 0}">
    <table>
        <caption>Lista de Bandas</caption>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Genero</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>

            <g:each var="banda" in="${bandas}">
                <tr>
                        <td>${banda.nome}</td>
                        <td>${banda.genero.descricao}</td>
                        <td>
                            <g:remoteLink controller="banda" action="alterar" update="divForm" id="${banda.id}">Alterar</g:remoteLink>
                            <a href="#" onclick="excluir(${banda.id})" >Excluir</a>
                        </td>
                    </tr>
            </g:each>

        </tbody>
    </table>
</g:if>
<g:else>
    <br>
    <h5>Não há bandas</h5>
</g:else>