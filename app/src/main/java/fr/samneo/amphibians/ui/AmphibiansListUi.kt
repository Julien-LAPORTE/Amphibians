package fr.samneo.amphibians.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import fr.samneo.amphibians.R
import fr.samneo.amphibians.model.Amphibian
import fr.samneo.amphibians.model.AmphibiansListUiState
import fr.samneo.amphibians.ui.theme.AmphibiansTheme
import fr.samneo.amphibians.viewmodel.AmphibiansListUiViewModel


@Composable
fun AmphibiansListUi(modifier: Modifier = Modifier) {
    val viewModel: AmphibiansListUiViewModel =
        viewModel(factory = AmphibiansListUiViewModel.Factory)
    val uiState = viewModel.uiState

    when (uiState) {
        is AmphibiansListUiState.Loading -> {}
        is AmphibiansListUiState.Success -> AmphibiansLazyColumn(amphibians = uiState.amphibians)
        is AmphibiansListUiState.Error -> {}
    }

}

@Composable
fun AmphibiansLazyColumn(amphibians: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.padding(
            start = dimensionResource(id = R.dimen.app_padding_small),
            end = dimensionResource(id = R.dimen.app_padding_small)
        ),
    ) {
        items(amphibians) { amphibian ->
            AmphibianCard(
                amphibian = amphibian,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.app_padding_medium))
            )
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(modifier, elevation = CardDefaults.cardElevation(10.dp)) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = amphibian.name + " (${amphibian.type})",
                modifier = Modifier.padding(dimensionResource(id = R.dimen.app_padding_small)),
                style = MaterialTheme.typography.titleMedium
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(amphibian.imgSrc)
                    .crossfade(true).build(),
                error = painterResource(id = R.drawable.ic_connection_error),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1.5f)
            )
            Text(
                text = amphibian.description,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.app_padding_small)),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun AmphibiansLazyColumnPreview() {
    val amphibians = listOf(
        Amphibian(
            "Test de nom",
            "Frog",
            "je suis une description de test afin d'afficher un preview du composable Card",
            "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/roraima-bush-toad.png"
        ), Amphibian(
            "Test de nom",
            "Frog",
            "je suis une description de test afin d'afficher un preview du composable Card",
            "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/roraima-bush-toad.png"
        )
    )
    AmphibiansLazyColumn(amphibians = amphibians)
}

@Preview
@Composable
fun AmphibianCardPreview(modifier: Modifier = Modifier) {
    val amphibian = Amphibian(
        "Test de nom",
        "Frog",
        "je suis une description de test afin d'afficher un preview du composable Card",
        "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/roraima-bush-toad.png"
    )
    AmphibiansTheme {
        AmphibianCard(amphibian, modifier.fillMaxWidth())
    }
}
