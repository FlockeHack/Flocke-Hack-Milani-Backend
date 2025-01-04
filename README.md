# flocke-hack-milani-backend

## Requests

### Recuperações
- Listar todas as recuperações
```
flocke-hack-milani-backend-production.up.railway.app/v1/recuperacoes-judiciais
```
```json
[
  {
    "id": "id-cadastrado-no-banco",
    "protocolNumber": "numero-de-protocolo-gerado",
    "name": "nome-da-empresa-em-recuperacao",
    "location": "local-para-mais-de-uma-empresa-listada: (NOVO HAMBURGO)",
    "relatedCompanies": "empresas-coligadas-a-recuperacao",
    "cnpj": "cnpj-da-empresa",
    "processNumber": "numero-do-processo",
    "county": "comarca",
    "court": "vara-responsavel",
    "judge": "juiz-do-caso",
    "judicialAdministrator": "administrador-do-escritorio-responsavel",
    "updateDate": "data-de-atualizacao-no-site",
    "periodDate": "data-do-periodo-do-processo-criado",
    "closedDate": "data-de-encerramento-do-processo",
    "assemblyId": "id-da-assembleia",
    "status": "status (ATIVO/ENCERRADO)"
  }
]
```
- Buscar uma recuperação por id
```
flocke-hack-milani-backend-production.up.railway.app/v1/recuperacoes-judiciais/{id}
```
- Listar todos os eventos relacionado a um numero de protocolo
```
flocke-hack-milani-backend-production.up.railway.app/v1/recuperacoes-judiciais/eventos/{numero-protocolo}
```
OBS: eventos são os itens relacionados a todos os documento de uma recuperação

### Falências
- Listar todas as falências
```
flocke-hack-milani-backend-production.up.railway.app/v1/falencias
```
```json
[
  {
    "id": "id-cadastrado-no-banco",
    "protocolNumber": "numero-de-protocolo-gerado",
    "name": "nome-da-empresa-em-recuperacao",
    "location": "local-para-mais-de-uma-empresa-listada: (NOVO HAMBURGO)",
    "relatedCompanies": "empresas-coligadas-a-recuperacao",
    "cnpj": "cnpj-da-empresa",
    "processNumber": "numero-do-processo",
    "county": "comarca",
    "court": "vara-responsavel",
    "judge": "juiz-do-caso",
    "judicialAdministrator": "administrador-do-escritorio-responsavel",
    "updateDate": "data-de-atualizacao-no-site",
    "periodDate": "data-do-periodo-do-processo-criado",
    "closedDate": "data-de-encerramento-do-processo",
    "assemblyId": "id-da-assembleia",
    "status": "status (ATIVO/ENCERRADO)"
  }
]
```
- Buscar uma falência por id
```
flocke-hack-milani-backend-production.up.railway.app/v1/falencias/{id}
```
- Listar todos os eventos relacionado a um numero de protocolo
```
flocke-hack-milani-backend-production.up.railway.app/v1/falencias/eventos/{numero-protocolo}
```

### Liquidações
- Listar todas as liquidações
```
flocke-hack-milani-backend-production.up.railway.app/v1/liquidacoes
```
```json
[
  {
    "id": "id-cadastrado-no-banco",
    "protocolNumber": "numero-de-protocolo-gerado",
    "name": "nome-da-empresa-em-recuperacao",
    "location": "local-para-mais-de-uma-empresa-listada: (NOVO HAMBURGO)",
    "relatedCompanies": "empresas-coligadas-a-recuperacao",
    "cnpj": "cnpj-da-empresa",
    "processNumber": "numero-do-processo",
    "county": "comarca",
    "court": "vara-responsavel",
    "judge": "juiz-do-caso",
    "judicialAdministrator": "administrador-do-escritorio-responsavel",
    "updateDate": "data-de-atualizacao-no-site",
    "periodDate": "data-do-periodo-do-processo-criado",
    "closedDate": "data-de-encerramento-do-processo",
    "assemblyId": "id-da-assembleia",
    "status": "status (ATIVO/ENCERRADO)"
  }
]
```
- Buscar uma falência por id
```
flocke-hack-milani-backend-production.up.railway.app/v1/liquidacoes/{id}
```
- Listar todos os eventos relacionado a um numero de protocolo
```
flocke-hack-milani-backend-production.up.railway.app/v1/liquidacoes/eventos/{numero-protocolo}
```

teste
