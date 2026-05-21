<h1 align="center">Wallety</h1>

<h3 align="center">
  <br>
    <img src="https://img.icons8.com/?size=128&id=13016&format=png&color=000000" alt="Wallety Logo" height="64" align="center">
  <br>
</h3>

<p align="center">
  <a href="#pencil2-descrição">Descrição</a> •
  <a href="#rocket-tecnologias">Tecnologias</a> •
  <a href="#gear-arquitetura-do-projeto">Arquitetura</a> •
  <a href="#computer-execução">Como Rodar</a>
</p>

---

## :pencil2: Descrição

O **Wallety** é um aplicativo Android nativo para controle financeiro pessoal e familiar.

A aplicação permite ao usuário gerenciar suas receitas e despesas com persistência local e oferece uma área "Família" que consome dados de uma Web API externa (Mock API). 

---

## :rocket: Tecnologias

### Interface Gráfica (UI)
* 🎨 **Jetpack Compose** — Construção declarativa de telas
* 🧩 **Material Design 3** — Estilização, tipografia e componentes (Theming)
* 🖼️ **Coil** — Carregamento assíncrono de imagens via URL

### Persistência e Rede
* 🗄️ **Room Database** — Banco de dados local (SQLite abstrato)
* 📡 **Retrofit 2 + Gson** — Comunicação HTTP com a Web API REST (MockAPI)

### Arquitetura e Qualidade
* 🏗️ **MVVM (Model-View-ViewModel)** — Separação de conceitos
* 🤖 **Compose UI Test** — Testes instrumentados de interface e navegação no emulador

---

## :gear: Arquitetura do Projeto

```text
Wallety/
│   ├── test/            # Testes unitários (ViewModels e Web API)
│   └── main/java/com/aa1_wallety/
│       ├── compose/     # Telas (Login, Home, Family) e ViewModels
│       ├── components/  # Componentes reutilizáveis (EntryCard, etc)
│       ├── repository/  # Room Database, DAOs e Repositórios
│       ├── service/     # Interfaces do Retrofit e chamadas de API
│       └── ui/theme/    # Cores, tipografia e tema geral
└── README.md
```
---

## :computer: Execução

### 📦 Pré-requisitos
* Android Studio
* Emulador ou dispositivo físico
* Conexão de internet (para sincronização inicial da API e do Coil, mas também funciona sem internet)

### 🔧 Passo a Passo

1. Abra o **Android Studio**.
2. Clique em **File > Open** e selecione a pasta do projeto clonado.
3. Aguarde o **Gradle Sync** terminar de baixar todas as dependências (Retrofit, Room, Compose, etc).
4. Selecione o seu emulador ou aparelho físico no menu superior.
5. Clique no botão de **Run** (ícone de Play verde `▶`) ou use o atalho.
