package com.trevo.trevoapp
import android.os.Bundle
import android.widget.TextView // TextView é usado para definir e modificar o texto na barra de ferramentas.
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController // O NavController é responsável por substituir o conteúdo do 'host' do nav fragment quando navegamos através da aplicação.
import androidx.navigation.ui.AppBarConfiguration // AppBarConfiguration mantém informações sobre como um 'Navigation UI' deve interagir com a barra de ações da sua atividade e o componente de navegação correspondente.
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.trevo.trevoapp.databinding.ActivityMainBinding // Este é um arquivo gerado automaticamente que contém referências para todas as visualizações que têm um ID no arquivo de layout XML.

class MainActivity : AppCompatActivity() {

    // Variáveis que serão inicializadas posteriormente
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialização da classe de ligação que foi gerada para a atividade (MainActivity)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Definir a barra de ferramentas para a aplicação.
        setSupportActionBar(binding.appBarMain.toolbar)

        // A barra de ações (ActionBar) normalmente contém o título da atividade e outras informações de interface do usuário.
        // Neste caso, estamos desativando o título da ActionBar.
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Definir o título da barra de ferramentas.
        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        toolbarTitle.text = "Título"

        // Configuração da navegação para esta atividade.
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // O NavController é responsável pela troca de conteúdo quando navegamos pela aplicação.
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Configurando a AppBar com os IDs dos destinos de nível superior.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_produtos, R.id.nav_orcamentos, R.id.nav_informacoes), drawerLayout)

        // Configurando a ActionBar para usar o NavController.
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configurando a NavigationView para usar o NavController.
        navView.setupWithNavController(navController)

        // Adicionando um listener que atualiza o título da barra de ferramentas com base no fragmento atualmente visível.
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_produtos -> toolbarTitle.text = "Produtos" // Quando o destino for 'nav_produtos', o título é definido como 'Produtos'
                R.id.nav_orcamentos -> toolbarTitle.text = "Meus Orçamentos" // Quando o destino for 'nav_orcamentos', o título é definido como 'Meus Orçamentos'
                R.id.nav_informacoes -> toolbarTitle.text = "Minhas Informações" // Quando o destino for 'nav_informacoes', o título é definido como 'Minhas Informações'
            }
        }

    }

    // Este método é chamado quando o botão de voltar é pressionado. Nesse caso, estamos usando o NavController para voltar na pilha de navegação.
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
