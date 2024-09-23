def inserir_item(carrinho):
    codigo = input("Código do Item: ")
    descricao = input("Descrição do Item: ")
    valor = float(input("Valor do Item: "))
    carrinho.append({
        "codigo": codigo,
        "descricao": descricao,
        "valor": valor,
        "acrescimo": 0,
        "desconto": 0
    })

def alterar_valor_item(carrinho, tipo):
    codigo = input("Código do Item: ")
    valor = float(input(f"Valor do {tipo}: "))
    for item in carrinho:
        if item['codigo'] == codigo:
            if tipo == "acréscimo":
                item['acrescimo'] += valor
            elif tipo == "desconto":
                item['desconto'] += valor

def alterar_valor_total(carrinho, tipo):
    valor_total = float(input(f"Valor total do {tipo}: "))
    valor_distribuido = valor_total / len(carrinho)
    for item in carrinho:
        if tipo == "acréscimo":
            item['acrescimo'] += valor_distribuido
        elif tipo == "desconto":
            item['desconto'] += valor_distribuido

def finalizar_venda(carrinho):
    total = 0
    print("Itens no Carrinho:")
    for item in carrinho:
        valor_final = item['valor'] + item['acrescimo'] - item['desconto']
        print(f"{item['descricao']}: {valor_final}")
        total += valor_final
    print(f"Valor total da venda: {total}")

def main():
    carrinho = []
    while True:
        opcao = input("\n1: Inserir Item\n2: Aplicar Acréscimo\n3: Aplicar Desconto\n4: Acréscimo Total\n5: Desconto Total\n6: Finalizar Venda\n7: Sair\nEscolha uma opção: ")

        if opcao == '1':
            inserir_item(carrinho)
        elif opcao == '2':
            alterar_valor_item(carrinho, "acréscimo")
        elif opcao == '3':
            alterar_valor_item(carrinho, "desconto")
        elif opcao == '4':
            alterar_valor_total(carrinho, "acréscimo")
        elif opcao == '5':
            alterar_valor_total(carrinho, "desconto")

        elif opcao == '6':
            finalizar_venda(carrinho)
            break
        elif opcao == '7':
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    main()
