const quickSort = (data) => {
	_quickSort(data, 0, data.length - 1);	
}

const swap = (data, posLeft, posRight) => {
    let tmp = data[posLeft];
    data[posLeft] = data[posRight];
    data[posRight] = tmp;
}

const threeMedian = (data, __left, __right) => {
    let middle = (__left + __right) / 2;
    let l = data[__left];
    let m = data[middle]
    let r = data[__right]
    
    // left < middle < right
    if (l < m && m < r) {
        swap(data, middle, __right)
    }
    // right < left < middle
    else if (r < l && l < m) {
        swap(data, __left, middle)
    }
    // middle < right < left
    else if (m < r && r < l) {
        swap(data, __right, __left)
    }
}

const _quickSort = (data, left, right) => {
    if (right > left) {
        // Teileschritt
        let i = partition(data, left, right);

        // Herrscheschritt
        _quickSort(data, left, i - 1);
        _quickSort(data, left + 1, right);
    }
}

const partition = (data, __left, __right) => {
    threeMedian(data, __left, __right);

    let pivot = data[__right];
    let left = __left - 1;
    let right = __right;

    while (true) {
        do { ++left } while(data[left] < pivot);
        do { --right } while(right >= __left && data[right] > pivot);

        if (left >= right) break;

        swap(data, left, right);
    }

    data[__right] = data[left];
    data[left] = pivot;

    return left;
}


const main = () => {
	const array = [3, 12, 312, 1235, 344, 11, 1, 11, 55, 5555, 777, 1];
    
    console.log(array);

    quickSort(array);

    console.log(array);
}

main();