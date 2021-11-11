package com.dokar.chiptextfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun <T : Chip> rememberChipTextFieldState(chips: List<T>): ChipInputFieldState<T> {
    return remember {
        ChipInputFieldState(chips)
    }
}

class ChipInputFieldState<T : Chip>(
    _chips: List<T> = emptyList()
) {
    var chips by mutableStateOf(_chips)

    fun addChip(chip: T) {
        val list = chips.toMutableList()
        list.add(chip)
        chips = list
    }

    fun removeChip(chip: T) {
        val list = chips.toMutableList()
        list.remove(chip)
        chips = list
    }

    fun removeLastChip() {
        val list = chips.subList(0, chips.size - 1)
        chips = list
    }

    fun clearChips() {
        chips = emptyList()
    }
}